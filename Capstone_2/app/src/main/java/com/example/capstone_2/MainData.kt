package com.example.capstone_2

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class MainData : Parcelable {
    var iv_profile: Int
    var tv_name: String?
    var tv_content: String?
    var item_delete: Int

    constructor(iv_profile: Int, tv_name: String?, tv_content: String?, item_delete: Int) {
        this.iv_profile = iv_profile
        this.tv_name = tv_name
        this.tv_content = tv_content
        this.item_delete = item_delete
    }

    protected constructor(`in`: Parcel) {
        iv_profile = `in`.readInt()
        tv_name = `in`.readString()
        tv_content = `in`.readString()
        item_delete = `in`.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(iv_profile)
        dest.writeString(tv_name)
        dest.writeString(tv_content)
        dest.writeInt(item_delete)
    }

//    companion object {
//        val CREATOR: Creator<MainData> = object : Creator<MainData?> {
//            override fun createFromParcel(`in`: Parcel): MainData? {
//                return MainData(`in`)
//            }
//
//            override fun newArray(size: Int): Array<MainData?> {
//                return arrayOfNulls(size)
//            }
//        }
//    }

    companion object CREATOR : Creator<MainData> {
        override fun createFromParcel(parcel: Parcel): MainData {
            return MainData(parcel)
        }

        override fun newArray(size: Int): Array<MainData?> {
            return arrayOfNulls(size)
        }
    }
}
