package com.example.nestordev.contactos_consumo.DiffCallback_Reload;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.example.nestordev.contactos_consumo.Models.User;

import java.util.ArrayList;

public class UserDiffCallback extends DiffUtil.Callback {

    private final ArrayList<User> mOldUserList;
    private final ArrayList<User> mNewUserList;

    public UserDiffCallback( ArrayList<User> oldUserList, ArrayList<User> newUserList) {
        mOldUserList = oldUserList;
        mNewUserList = newUserList;
    }

    @Override
    public int getOldListSize() {
        return mOldUserList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewUserList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldUserList.get(oldItemPosition).id ==  mNewUserList.get(newItemPosition).id;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

        return true; //olduser.username.equals(newuser.username);

    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
