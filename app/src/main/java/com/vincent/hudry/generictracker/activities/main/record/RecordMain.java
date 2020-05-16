package com.vincent.hudry.generictracker.activities.main.record;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.activities.main.RWAdapter2;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecordMain.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecordMain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecordMain extends Fragment {

    private OnFragmentInteractionListener mListener;

    private View v;
    public RecordMain() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RecordMain.
     */
    public static RecordMain newInstance() {
        RecordMain fragment = new RecordMain();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the configLayout for this fragment

        v = inflater.inflate(R.layout.fragment_record_main, container, false);

        fillRecordTab();

        return v;
    }

    private void fillRecordTab() {
        File path = getActivity().getFilesDir();
        File directory = new File(path.getPath());
        File[] files = directory.listFiles();

        //if in record mode
        RecyclerView rw = v.findViewById(R.id.recyclerview2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rw.setLayoutManager(linearLayoutManager);
        RWAdapter2 adapter = new RWAdapter2(files);
        rw.setAdapter(adapter);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /*
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        */
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
