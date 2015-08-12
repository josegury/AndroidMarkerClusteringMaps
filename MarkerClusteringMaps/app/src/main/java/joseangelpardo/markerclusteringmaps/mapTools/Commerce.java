package joseangelpardo.markerclusteringmaps.mapTools;

import com.google.android.gms.maps.model.LatLng;

import joseangelpardo.markerclusteringmaps.libreryMaps.clustering.ClusterItem;

/**
 * Created by josea on 12/08/2015.
 */
public class Commerce implements ClusterItem {
    public final String name;
    public final int profilePhoto;
    private final LatLng mPosition;

    public Commerce(LatLng position, String name, int pictureResource) {
        this.name = name;
        profilePhoto = pictureResource;
        mPosition = position;
    }
    public Commerce(LatLng position, String name) {
        this.name = name;
        profilePhoto = 0;
        mPosition = position;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}