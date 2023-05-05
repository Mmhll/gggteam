package com.ggg.gggapp.database

class Database {

   /* fun getFirebaseReference(path : String) : DatabaseReference{
        return FirebaseDatabase
            .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference(path)
    }


    fun putUser(array : ArrayList<User>, user : User){
        var exists = false
        for (i in array){
            if (i == user){
                exists = true
            }
        }
        if (!exists) {
            getFirebaseReference("Users").child(Firebase.auth.uid.toString()).setValue(user).addOnCompleteListener {
                Log.e("TAG", "Success")
            }
        }
    }

    fun changeUser(user : User){
        getFirebaseReference("Users").child(Firebase.auth.uid.toString()).setValue(user).addOnCompleteListener {
            Log.e("TAG", "Success")
        }
    }

    fun getUsers() : ArrayList<User>{
        var array = ArrayList<User>()
        getFirebaseReference("Users").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (snap in snapshot.children) {
                        array.add(snap.getValue(User::class.java)!!)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        return array
    }*/

}