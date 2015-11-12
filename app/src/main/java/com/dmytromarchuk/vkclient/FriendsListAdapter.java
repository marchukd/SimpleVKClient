package com.dmytromarchuk.vkclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Dmytro on 10.11.2015.
 */
public class FriendsListAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<Friend> friends;

    FriendsListAdapter(Context _context, ArrayList<Friend> _friends) {
        context = _context;
        friends = _friends;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return friends.size();
    }

    @Override
    public Object getItem(int position) {
        return friends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = inflater.inflate(R.layout.friend_item, parent, false);
        Friend friend = getFriend(position);

        ((TextView) view.findViewById(R.id.item_firstlastname)).setText(friend.getFlName());
        Picasso.with(context).load(friend.getUrlAvatar()).into((ImageView) view.findViewById(R.id.item_photo));
        return view;
    }

    private Friend getFriend(int pos) {
        return friends.get(pos);
    }
}
