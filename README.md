**AndroidMarkerClusteringMaps**
=================== 
----------
Introducción
===================
La utilidad de la agrupación de markers le ayuda a gestionar múltiples marcadores en diferentes niveles de zoom.
Para aumentar el rendimiento del dispositivo, debemos crear este tipo de elementos para que agrupe los distintos marks, pues si hay demasiados la aplicación no funcionara correctamente ya que tendrá que renderizar demasiados elementos.

La aplicación creada esta lista para usarse, lo único que hay que hacer es poner la clave para que funcione el mapa y listo.

Para importar la aplicación a tú proyecto solo debes refactorizar los paquetes e importar los archivos.

----------
Marker personalizado
===================
La aplicación esta preparada para la modificación de los markers, ya que actualmente simplemente mostrara el icono por defecto de android.
Para realizar mostrar la imagen debemos descomentar los métodos onBeforeClusterItemRendered y onBeforeClusterRendered, tras ello le modificaremos el método addItems.

> protected void onBeforeClusterItemRendered(Commerce commerce, MarkerOptions markerOptions) {            
            mImageView.setImageResource(commerce.profilePhoto);
            Bitmap icon = mIconGenerator.makeIcon();
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon))
            markerOptions.title(commerce.name);
        }
> 
> Blockquote

        @Override
        protected void onBeforeClusterRendered(Cluster<Commerce> cluster, MarkerOptions markerOptions) {
            
            List<Drawable> profilePhotos = new ArrayList<Drawable>(Math.min(4, cluster.getSize()));
            int width = mDimension;
            int height = mDimension;

            for (Commerce c : cluster.getItems()) {
                // Draw 4 at most.
                if (profilePhotos.size() == 4) break;
                Drawable drawable = getResources().getDrawable(c.profilePhoto);
                drawable.setBounds(0, 0, width, height);
                profilePhotos.add(drawable);
            }
            MultiDrawable multiDrawable = new MultiDrawable(profilePhotos);
            multiDrawable.setBounds(0, 0, width, height);

            mClusterImageView.setImageDrawable(multiDrawable);
            Bitmap icon = mClusterIconGenerator.makeIcon(String.valueOf(cluster.getSize()));
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));
        }

> private void addItems() {
        for (int i=0; i<200;i++) {
                        //mClusterManager.addItem(new Commerce(position(), "Commerce-"+i,Imagen));
        }
}
//creamos un nuevo contructor de Commerce para que pueda contener una imagen.

El metodo onBeforeClusterItemRendered() nos sirve para la modificación del icono de cada comercio, mientras que onBeforeClusterRendered() modifica la apariencia de los elementos cuando están agrupados.

