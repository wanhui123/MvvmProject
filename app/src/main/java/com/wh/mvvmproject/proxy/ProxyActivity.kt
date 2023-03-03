package com.wh.mvvmproject.proxy

import android.os.Bundle
import com.wh.mvvmproject.base.BaseActivity
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy


/**
 * Created by WanHui on 2023/3/3
 * Android代理模式(静态代理，动态代理，Retrofit代理模式分析)
 * https://blog.csdn.net/weixin_46039528/article/details/128167508
 */
class ProxyActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //第一步先生成我们想代理的对象，我们想代理的这个对象是Student
        val student = Student()
        //A是我们的代理类，生成我们的代理对象
        val a = A()
        //引用指向我们的被代理对象student
        a.`object` = student
        //第一个参数写被代理对象的Classloader
        //p指向Proxy.newProxyInstance所生成的对象，它是代理的接口所生成的对象
        //访问的是代理接口的那个test方法
        (Proxy.newProxyInstance(student.javaClass.classLoader, student.javaClass.interfaces, a) as Person).test()
    }


    interface Person {
        fun test()
    }

    class Student : Person {
        override fun test() {
            println("Student")
        }
    }

    class Teacher : Person {
        override fun test() {
            println("Teacher")
        }
    }

    class A : InvocationHandler {
        //这个引用会和静态代理一样指向我们的要代理的真实对象
        var `object`: Any? = null

        //这个地方写我们需要额外插入的代码
        @Throws(Throwable::class)
        override operator fun invoke(proxy: Any?, method: Method, args: Array<Any?>?): Any? {
            println("java前   ${args.toString()}")
            //首先我们要先调用一下被代理对象的被代理方法。
//            method.invoke(`object`,args)
            method.invoke(`object`)
            println("java后")
            return null
        }
    }
}