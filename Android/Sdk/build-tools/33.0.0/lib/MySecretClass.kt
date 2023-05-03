package jp.go.mhlw.covid19r



class MySecretClass : java.io.Serializable{
    fun returnSecret(name: String) : String{
        return "$name I'll tell you secret ..."
    }
}