package premkumar.rai.oechat.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import premkumar.rai.oechat.R;
import premkumar.rai.oechat.adapter.ChatListAdapter;
import premkumar.rai.oechat.model.ChatList;


public class ChatsFragment extends Fragment {


    public ChatsFragment() {
        // Required empty public constructor
    }


    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        List<ChatList> list = new ArrayList<>();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list.add(new ChatList("11", "Salman", "Hi", "1/20/2020", "https://resize.indiatvnews.com/en/resize/newbucket/1200_-/2020/04/pjimage-2-1586692899.jpg"));
        list.add(new ChatList("12", "Jackma", "hellow", "2/12/2020", "https://m.jagranjosh.com/imported/images/E/GK/jack-ma-biography.jpg"));


        recyclerView.setAdapter(new ChatListAdapter(list, getContext()));

        return view;
    }

}