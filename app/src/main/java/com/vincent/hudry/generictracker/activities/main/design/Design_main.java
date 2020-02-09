package com.vincent.hudry.generictracker.activities.main.design;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.activities.main.RWAdapter;
import com.vincent.hudry.generictracker.dialogs.FileCreateDialog;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Design_main.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Design_main#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Design_main extends Fragment {

    private OnFragmentInteractionListener mListener;

    private View v;

    public Design_main() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Design_main.
     */
    public static Design_main newInstance() {
        Design_main fragment = new Design_main();
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
        v = inflater.inflate(R.layout.fragment_design_main, container, false);
        FloatingActionButton fab = v.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileCreateDialog fileCreateDialog = new FileCreateDialog(getActivity());
                fileCreateDialog.that.show();
            }
        });

        fillDesignTab();

        return v;
    }


    public void fillDesignTab() {
        //TODO response depends on active tab
        File path = getActivity().getFilesDir();
        File directory = new File(path.getPath());
        File[] files = directory.listFiles();

        //if in design mode
        RecyclerView rw = v.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rw.setLayoutManager(linearLayoutManager);
        RWAdapter adapter = new RWAdapter(files);
        rw.setAdapter(adapter);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
        /*else {
        /*    throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");

        }*/
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
