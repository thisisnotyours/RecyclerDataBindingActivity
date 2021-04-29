package com.example.recyclerdatabindingactivity.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recyclerdatabindingactivity.recycerview.items.UniverseItem;
import com.example.recyclerdatabindingactivity.repositories.UniverseRepository;

import java.util.List;



public class MainActivityViewModel extends ViewModel {

    // mutable live data actually extends live data  // is can be changed
    private MutableLiveData<List<UniverseItem>> mUniverseItems;   //sub class of LiveData...
    private UniverseRepository mRepo;

    public void init(){
        if (mUniverseItems != null){
            return;
        }
        mRepo= UniverseRepository.getInstance();
        mUniverseItems= mRepo.getUniverseItems();
    }



    public LiveData<List<UniverseItem>> getUniverseItems(){   // LiveData [메소드]에서 MutableLiveData 를 return 해줌..
                                                                //live data can indirectly change through mutable live data..
        return mUniverseItems;                                  //but [observe] to change dat
    }
}






