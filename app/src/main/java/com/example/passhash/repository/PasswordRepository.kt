package com.example.passhash.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.passhash.data.Password

/**
 * @author : Mingaleev D
 * @data : 17/10/2022
 */

class PasswordRepository {
  private val listOfPasswordMock = mutableListOf<Password>(
    Password(0, "MockPassword1"),
    Password(1, "MockPassword2"),
    Password(2, "MockPassword3"),
    Password(3, "MockPassword4")
  )

  private val mPasswords = ArrayList<Password>(listOfPasswordMock)
  private val mPasswordLiveData = MutableLiveData<List<Password>>().apply {
    value = mPasswords
  }

  val passwords: LiveData<List<Password>>
    get() = mPasswordLiveData

  fun save(newPassword: String) {
    mPasswords.add(
      Password(mPasswords.size.toLong(), newPassword)
    )
    mPasswordLiveData.value = mPasswords
  }

  fun update(password: Password) {
    val idx = listOfPasswordMock.indexOf(password)
    listOfPasswordMock[idx] = password
  }

  fun delete(password: Password) {
    listOfPasswordMock.remove(password)
  }
}