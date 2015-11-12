package com.dmytromarchuk.vkclient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKUsersArray;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Dmytro on 10.11.2015.
 */
public class FriendsFragment extends Fragment {
    ArrayList<Friend> friends = new ArrayList<>();
    FriendsListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.friends_fragment, null);

        ListView listView = (ListView) view.findViewById(R.id.friends_list);
        adapter = new FriendsListAdapter(getContext(), friends);
        listView.setAdapter(adapter);

        VKParameters params = new VKParameters();
        params.put("fields", "first_name, last_name, photo_100");
        params.put("order", "hints");
        VKRequest request = VKApi.friends().get(params);
        request.setPreferredLang("ru");
        final VKUsersArray allUsersList = new VKUsersArray();
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                try {
                    allUsersList.parse(response.json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                refreshFriendsList(allUsersList);
            }
        });
        return view;
    }

    private void refreshFriendsList(VKUsersArray usersList) {
        for (int i = 0; i < usersList.size(); i++) {
            String avatar = usersList.get(i).photo_100;
            String first_last_name = usersList.get(i).first_name + " " + usersList.get(i).last_name;
            friends.add(new Friend(first_last_name, avatar));
        }
        adapter.notifyDataSetChanged();
    }
}
