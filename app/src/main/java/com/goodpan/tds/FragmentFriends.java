package com.goodpan.tds;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentFriends.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentFriends#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFriends extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ListView around_area_lv;
    private SimpleAdapter listAdapter;

    public FragmentFriends() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentFriends.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentFriends newInstance(String param1, String param2) {
        FragmentFriends fragment = new FragmentFriends();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_fragment_friends, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        // 防止被T后，没点确定按钮然后按了home键，长期在后台又进app导致的crash
        if (savedInstanceState != null
                && savedInstanceState.getBoolean("isConflict", false))
            return;
        //获取listview
        around_area_lv = (ListView)getView().findViewById(R.id.around_area_lv);
        listAdapter = new SimpleAdapter(
                this.getContext(),
                getData(),
                R.layout.list_item,
                new String[]{"ranking","city","tds"},
                new int[]{R.id.ranking,R.id.city,R.id.tds});
        around_area_lv.setAdapter(listAdapter);
    }

    private List<Map<String,Object>> getData(){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("ranking",1);
        map.put("city","北京");
        map.put("tds",55);
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("ranking",2);
        map.put("city","上海");
        map.put("tds",65);
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("ranking",3);
        map.put("city","天津");
        map.put("tds",68);
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("ranking",4);
        map.put("city","广州");
        map.put("tds",68);
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("ranking",5);
        map.put("city","深圳");
        map.put("tds",68);
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("ranking",6);
        map.put("city","厦门");
        map.put("tds",68);
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("ranking",7);
        map.put("city","重庆");
        map.put("tds",68);
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("ranking",8);
        map.put("city","成都");
        map.put("tds",63);
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("ranking",9);
        map.put("city","福州");
        map.put("tds",63);
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("ranking",10);
        map.put("city","武汉");
        map.put("tds",63);
        list.add(map);

        return list;
    }
}
