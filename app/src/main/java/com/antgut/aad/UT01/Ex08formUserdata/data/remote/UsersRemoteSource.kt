package com.antgut.aad.UT01.Ex08formUserdata.data.remote

import com.antgut.aad.UT01.Ex08formUserdata.domain.Address
import com.antgut.aad.UT01.Ex08formUserdata.domain.Company
import com.antgut.aad.UT01.Ex08formUserdata.domain.Geo
import com.antgut.aad.UT01.Ex08formUserdata.domain.Users


class UsersRemoteSource {
    fun getUsers(): List<Users>{
        return mutableListOf(
            Users( 1, "User1", "Username1", "email1", Address("street1", "suite1", "city1", "zipcode1", Geo("latitude1", "longitude1")), "phone1", "website1", Company("company_name1", "catchPhrase1", "bs1") ),
            Users( 2, "User2", "Username2", "email2", Address("street2", "suite2", "city2", "zipcode2", Geo("latitude2", "longitude2")), "phone2", "website2", Company("company_name2", "catchPhrase2", "bs2") ),
            Users( 3, "User3", "Username3", "email3", Address("street3", "suite3", "city3", "zipcode3", Geo("latitude3", "longitude3")), "phone3", "website3", Company("company_name3", "catchPhrase3", "bs3") ),
            Users( 4, "User4", "Username4", "email4", Address("street4", "suite4", "city4", "zipcode4", Geo("latitude4", "longitude4")), "phone4", "website4", Company("company_name4", "catchPhrase4", "bs4") ),
            Users( 5, "User5", "Username5", "email5", Address("street5", "suite5", "city5", "zipcode5", Geo("latitude5", "longitude5")), "phone5", "website5", Company("company_name5", "catchPhrase5", "bs5") ),
            Users( 6, "User6", "Username6", "email6", Address("street6", "suite6", "city6", "zipcode6", Geo("latitude6", "longitude6")), "phone6", "website6", Company("company_name6", "catchPhrase6", "bs6") ),
            Users( 7, "User7", "Username7", "email7", Address("street7", "suite7", "city7", "zipcode7", Geo("latitude7", "longitude7")), "phone7", "website7", Company("company_name7", "catchPhrase7", "bs7") )
        )
    }
    fun getUser(userId: Int): Users {
        return Users( userId, "User$userId", "Username$userId", "email$userId", Address("street$userId", "suite$userId", "city$userId", "zipcode$userId", Geo("latitude$userId", "longitude$userId")), "phone$userId", "website$userId", Company("company_name$userId", "catchPhrase$userId", "bs$userId") )
    }
}