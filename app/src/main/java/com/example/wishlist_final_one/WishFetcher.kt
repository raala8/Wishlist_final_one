package com.example.wishlist_final_one

class WishFetcher {
    companion object {
        //val url = "url"
        //val price = "123.00"

        private val nameList = mutableListOf<String>()
        private val urlList = mutableListOf<String>()
        private val priceList = mutableListOf<String>()

        fun addWishes(name: String, url: String, price: String) {
            nameList.add(name)
            urlList.add(url)
            priceList.add(price)

        }

        // update for loop range
        fun getWishes(): MutableList<Wish> {
            val wishes : MutableList<Wish> = ArrayList()
            for (i in nameList.indices) {
                val wish = Wish(nameList[i], urlList[i], priceList[i])
                wishes.add(wish)
            }
            return wishes
        }
        //        // update for loop range
//        fun getWishes(): MutableList<Wish> {
//            var wishes : MutableList<Wish> = ArrayList()
//            for (i in 0..wishCount) {
//                val wish = Wish(nameList[i], urlList[i], priceList[i])
//                wishes.add(wish)
//            }
//            return wishes
//        }
    }
}