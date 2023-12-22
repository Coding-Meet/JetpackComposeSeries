package com.coding.meet.jetpackcomposeseries.components

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.coding.meet.jetpackcomposeseries.MainViewModel
import java.io.Serializable

/**
 * @author Coding Meet
 * Created 13-12-2023 at 11:12 am
 */

@Composable
fun StateScreen() {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    Log.d("TAG", "initial Composition")
    Button(onClick = {
        count++
        Log.d("TAG", count.toString())
    }) {
        Log.d("TAG", "re-Composition")
        Text(text = "$count Click")
    }
}

@Composable
fun IncScreen(mainViewModel: MainViewModel) {
    Button(onClick = {
        mainViewModel.inc()
    }) {
        Text(text = "${mainViewModel.count} Inc")
    }
}

@Composable
fun DecScreen(mainViewModel: MainViewModel) {
    Button(onClick = {
        mainViewModel.dec()
    }) {
        Text(text = "${mainViewModel.count} Dec")
    }
}


@Composable
fun MutableStateListExample() {
    val items = remember {
       mutableStateListOf<String>()
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        items.forEach{item ->
            Text(text = item)

        }

        Button(onClick = {
            items.add("New Item ${items.size + 1}")

        }) {
            Text(text = "Add Item")
        }
    }

}


data class Student(var name:String, var age: Int)


val studentValSaver = Saver<Student,Map<String,Any>>(
    save = {
        mapOf(
            "name" to it.name,
            "age" to it.age
        )
    },
    restore = {
        val name = it["name"] as String
        val age = it["age"] as Int
        Student(name,age)
    }
)

class StudentSaverClass() : Saver<Student?,Map<String,Any>>{
    override fun restore(value: Map<String, Any>): Student {
        val name = value["name"] as String
        val age = value["age"] as Int
       return Student(name,age)
    }

    override fun SaverScope.save(value: Student?): Map<String, Any>? {
      value?.let {
          return  mapOf(
              "name" to value.name,
              "age" to value.age
          )
      } ?: return null

    }

}

@Composable
fun CustomSaverExample() {

    var studentModel by rememberSaveable(
        stateSaver = StudentSaverClass()
    ) {
        mutableStateOf<Student?>(null)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        studentModel?.let { it
            Text(text = "name: ${it.name}", fontSize = 30.sp)
            Text(text = "age: ${it.age}", fontSize = 30.sp)
        }
        Button(onClick = {
            studentModel = Student(
                name = "meet",
                age = 21
            )

        }) {
            Text(text = "Update field")
        }
    }
}
