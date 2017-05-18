package redwolf.com.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //  When 替代 Switch
        mBtnWhen.setOnClickListener {
            val count: Int = 70;
            //  很简单 就不带注释了 数字只能这么来 in X..X  字符串可以直接 in X
            when (count) {
                in 80..100 -> Toast.makeText(this, "80..100", Toast.LENGTH_SHORT).show();
                in 71..79 -> Toast.makeText(this, "71..79", Toast.LENGTH_SHORT).show();
                in 70..70 -> Toast.makeText(this, "70", Toast.LENGTH_SHORT).show();
                else -> Toast.makeText(this, "else", Toast.LENGTH_SHORT).show();
            }
        }

        mBtnExtend.setOnClickListener {
            //  类的对象可直接使用
            mBtnExtend.extendMethod("RedWolf")
        }
        mBtnFilter.setOnClickListener {
            var list = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 22, 33);
            //  Filter用于筛选
            //  例   取出list中3的倍数
            var newList = list.filter { it % 3 == 0 }

            LogI("" + newList)
        }
        mBtnMapMethod.setOnClickListener {
            var list = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 22, 33);
            //  map用于变换
            //  例   使List中的每一个元素自乘
            var newList = list.map { it * it }

            LogI("" + newList)
        }
        mBtnReduce.setOnClickListener {
            var list = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 22, 33);
            //  Reduce 主要用于求所有元素的结果(加减乘除立方开放 等等)
            //  例   得到和
            var sum = list.reduce { acc, i -> acc + i }

            LogI("" + sum)
        }

        mBtnList.setOnClickListener {
            var list = arrayListOf<Int>(1, 2, 3, 4, 5);
            //  添加元素
            list.add(111);
            //  删除元素
            list.remove(2);
            //  删除指定位置的元素
            list.removeAt(1);
            //  遍历
            for (item in list) {
                LogI("" + item);
            }
        }
        mBtnMap.setOnClickListener {
            //  只读 没有put,replace remove 等方法 可以不赋初值 但是没意义
            var map1 = mapOf<String, Int>();
            //  普通
            var map = mutableMapOf<String, Int>(Pair("1111", 2222), Pair("3333", 4444), Pair("5555", 6666));
            //  使用方法和HadhMap一致
            map.put("Key", 12345);
            //  遍历
            for ((key, value) in map) {
                LogI("$key->$value")
            }
        }
        mBtnJavaBean.setOnClickListener {
            javaBean();
        }

    }

    //  类扩展
    fun Button.extendMethod(name: String) {
        LogI("无奈 extendMethod_" + name);
    }


    //  表明message不可以为null
    fun LogINull(message: String?) {
        Log.i("RedWolf", message);
    }

    //  表明message不可以为null
    fun LogI(message: String) {
        Log.i("RedWolf", message);
    }


    //  Kotlin 定义变量有两种方式,可以为 Null 和不可以为 Null
    // 在变量类型后面 加"?"表示该变量 可以为 Null
    fun nullTest() {
        //  一个可以为null的字符串str
        var str: String? = null;
        //  一个不可以为null的字符串str1
        //var str1: String = null;    //  会报错
        var str1: String = "";    //  不会报错

        // 可能为null的变量不可以直接调用它的方法 会报错
        // str.count();
        //  如果str为空 咋不走这个方法 否则 执行str.count
        str?.count();
        //  不管str是否为null都要走这个方法,为空就抛出 空指针
        str!!.count();
        //  str1不可以为空 所以可以直接调用方法
        str1.count();

    }

    // 实体类使用
    fun javaBean() {
        var kStu: KStudent = KStudent("RedWolf", 108);
        LogI(kStu.toString());
        var stu: Student = Student("RedWolfChao", 10800);
        LogI(stu.toString());
    }
}
