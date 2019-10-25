package com.mrk2.flameados;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FragmentLight extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    //interface to conect the activity, pd. default code
    private OnFragmentInteractionListener mListener;
    //Control

    EditText etMessage;
    Button btnSend;
    TextView showMessage;
    //View
    View view;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(ARG_PARAM1 != null){
            try {
                showMessage.setText(this.getArguments().getString(ARG_PARAM1));
            }catch (Exception e){
                //  Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    }

    public FragmentLight() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentLight newInstance(String param1) {
        FragmentLight fragment = new FragmentLight();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fragment_light, container, false);
        controls();
        events();
        return view;
    }

    private void events() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the text on EditText
                String string = etMessage.getText().toString();
                //Send the string to the interface
                mListener.onFragmentInteraction(string);
            }
        });
    }

    private void controls() {
        btnSend = view.findViewById(R.id.dark_frag_btnSend);
        etMessage = view.findViewById(R.id.dark_frag_etMessage);
        showMessage = view.findViewById(R.id.dark_frag_txtMessage);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String text) {
        if (mListener != null) {
            mListener.onFragmentInteraction(text);
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

    @Override
    public void onClick(View v) {
        //Toast.makeText(FragmentLight.this.getContext(), "entra", Toast.LENGTH_SHORT).show();

        /**I have 1 button, so, this method catch all the click event on the fragment, doesn't matter the cuantity of buttons
         *onClick works with an if or a switch comparing ids
         *examples:
         *switch(view.getId()){
            case R.id.myButton:
                    YOUR OWN ACTIONS
                break;
         }*/

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String text);
    }
}
/**
 * Implement a interface View.OnClickListener
 * Implement the method of the interface
 * Edit parameters of the interface on onFragmentInteraction according to your necessities
 * Create the instance of our controls
 * Create a View
 * Initialize the view on the method onCreateView
 * Add the possible events controls on the method onClick()
 */