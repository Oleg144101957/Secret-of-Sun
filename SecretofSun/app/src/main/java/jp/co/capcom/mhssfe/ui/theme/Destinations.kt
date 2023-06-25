package jp.co.capcom.mhssfe.ui.theme

sealed class Destinations(val route: String){
    object First : Destinations("first_dest")
    object Second : Destinations("second_dest")
    object Third : Destinations("third_dest")
    object Fourth : Destinations("fourth_dest")
}
