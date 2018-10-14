package gitmad.gitmadheatmap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import gitmad.gitmadheatmap.firebase.FbDatabase;
import gitmad.gitmadheatmap.model.Friend;

public class FriendsFragment extends Fragment {


    public static FriendsFragment newInstance() {
        return new FriendsFragment();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_friends, container, false);

        FbDatabase db = new FbDatabase();

        db.getFriends(new IRetrieveFriendsCallback() {
            @Override
            public void onFinish(ArrayList<Friend> friends) {
                FriendsAdapter friendsAdapter = new FriendsAdapter( getContext(), friends );
                ListView listView = v.findViewById( R.id.friends_list_friends );
                listView.setAdapter( friendsAdapter );
            }
        });

        return v;
    }
}
