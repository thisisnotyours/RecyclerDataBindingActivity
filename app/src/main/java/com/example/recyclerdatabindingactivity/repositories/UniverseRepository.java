package com.example.recyclerdatabindingactivity.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.recyclerdatabindingactivity.recycerview.items.UniverseItem;

import java.util.ArrayList;
import java.util.List;



public class UniverseRepository {

    private static UniverseRepository instance;
    private ArrayList<UniverseItem> dataSet= new ArrayList<>();


    public static UniverseRepository getInstance(){
        if (instance == null){
            instance= new UniverseRepository();
        }
        return instance;
    }


    //Data cash like it's from web server
    //Pretend to get data from a webservice or online source
    public MutableLiveData<List<UniverseItem>> getUniverseItems(){    //make your database queries or data cash here.
        setUniverseItems();

        MutableLiveData<List<UniverseItem>> data= new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setUniverseItems(){
        dataSet.add(new UniverseItem("https://png.pngtree.com/png-clipart/20190614/original/pngtree-beautiful-earth-elements-png-image_3704319.jpg",
                                    "Earth"));
        dataSet.add(new UniverseItem("https://pngimg.com/uploads/mars_planet/mars_planet_PNG13.png",
                                    "Mars"));
        dataSet.add(new UniverseItem("https://mpng.subpng.com/20180205/xze/kisspng-display-resolution-image-file-formats-jupiter-png-photos-5a77ecc8068c83.1264113015178088400268.jpg",
                                    "Jupiter"));
        dataSet.add(new UniverseItem("https://atlas-content-cdn.pixelsquid.com/stock-images/sun-KaEDP62-600.jpg",
                                    "Sun"));
        dataSet.add(new UniverseItem("https://upload.wikimedia.org/wikipedia/commons/9/94/Pluto-transparent.png",
                                    "Pluto"));
        dataSet.add(new UniverseItem("https://i.pinimg.com/originals/a1/01/e2/a101e22fc458c1110d418ee309f240c8.png",
                                    "Moon"));
        dataSet.add(new UniverseItem("https://atlas-content-cdn.pixelsquid.com/stock-images/mercury-planet-K603Y13-600.jpg",
                                    "Mercury"));
        dataSet.add(new UniverseItem("https://cdn.imgbin.com/13/2/15/imgbin-saturn-others-f2C27CaHea9EHBy82h3c7k93u.jpg",
                                    "Saturn"));
        dataSet.add(new UniverseItem("https://png.pngtree.com/png-clipart/20190614/original/pngtree-beautiful-earth-elements-png-image_3704319.jpg",
                                    "Earth"));
        dataSet.add(new UniverseItem("https://pngimg.com/uploads/mars_planet/mars_planet_PNG13.png",
                                    "Mars"));
        dataSet.add(new UniverseItem("https://mpng.subpng.com/20180205/xze/kisspng-display-resolution-image-file-formats-jupiter-png-photos-5a77ecc8068c83.1264113015178088400268.jpg",
                                    "Jupiter"));
        dataSet.add(new UniverseItem("https://atlas-content-cdn.pixelsquid.com/stock-images/sun-KaEDP62-600.jpg",
                                    "Sun"));
        dataSet.add(new UniverseItem("https://upload.wikimedia.org/wikipedia/commons/9/94/Pluto-transparent.png",
                                    "Pluto"));
        dataSet.add(new UniverseItem("https://i.pinimg.com/originals/a1/01/e2/a101e22fc458c1110d418ee309f240c8.png",
                                    "Moon"));
        dataSet.add(new UniverseItem("https://atlas-content-cdn.pixelsquid.com/stock-images/mercury-planet-K603Y13-600.jpg",
                                    "Mercury"));
        dataSet.add(new UniverseItem("https://cdn.imgbin.com/13/2/15/imgbin-saturn-others-f2C27CaHea9EHBy82h3c7k93u.jpg",
                                    "Saturn"));
    }


}
