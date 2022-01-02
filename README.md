
## PowerMeter

En Argentina las facturas de consumo eléctrico son bimestrales, por lo cual uno no sabe cuánto es el consumo que lleva aproximado hasta que lee su factura. En verano esta situación hace que exista incertidumbre, ya que al utilizar aires acondicionados o electrodomésticos para enfriar suelen consumir en grandes cantidades. 

PowerMeter está compuesto por dos partes, electrónica y app. 

> App 

Para la construcción de la app utilice Android Studio como IDE, junto a Firebase como database, mediante consultas se generaban las estadísticas dentro de la app.

La busqueda de cada seccion de la app fue sectorizar la informacion obtenida. Tension y corriente actual, potencia consumida en graficas temporales y costo al dia actual.

> Capturas de la app

<p float="left">
<img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270218536_10209803551601399_6434419400141604651_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=730e14&_nc_ohc=yvLg3rkcEL4AX-H8OYl&tn=QSDM3Ops55fQHkQT&_nc_ht=scontent.fros2-1.fna&oh=00_AT9LHL6jVYmYPkra-pdsPajuNL-GtqGc1QbewRtnGoQANg&oe=61D72AAD" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270218536_10209803551601399_6434419400141604651_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=730e14&_nc_ohc=yvLg3rkcEL4AX-H8OYl&tn=QSDM3Ops55fQHkQT&_nc_ht=scontent.fros2-1.fna&oh=00_AT9LHL6jVYmYPkra-pdsPajuNL-GtqGc1QbewRtnGoQANg&oe=61D72AAD" width="200" height="400" />
<img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/269600828_10209803550841380_1296861305794778704_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=K8ZK5uSdARIAX9IV8AQ&tn=QSDM3Ops55fQHkQT&_nc_ht=scontent.fros2-1.fna&oh=00_AT_69LPClxeJDogr5PuGPsyDaqgzVXvI0cvQ4Wprz5joog&oe=61D80713" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/269600828_10209803550841380_1296861305794778704_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=K8ZK5uSdARIAX9IV8AQ&tn=QSDM3Ops55fQHkQT&_nc_ht=scontent.fros2-1.fna&oh=00_AT_69LPClxeJDogr5PuGPsyDaqgzVXvI0cvQ4Wprz5joog&oe=61D80713" width="200" height="400" />
<img src="https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/270277274_10209803551161388_5546425450129861146_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=730e14&_nc_ohc=Db6BpdwkH6gAX-bCP0D&_nc_oc=AQkX04PmmAK11ZOew7hDnRKcvXxelLFKvqaTzYsIs-lbGU9gklhwbW96zurtQ_LQ9r4&_nc_ht=scontent.fros2-2.fna&oh=00_AT95r6a_TOuB-LXGSzoubZNKOqVZLZHv1PKm5PApzcthGw&oe=61D76091" data-canonical-src="https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/270277274_10209803551161388_5546425450129861146_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=730e14&_nc_ohc=Db6BpdwkH6gAX-bCP0D&_nc_oc=AQkX04PmmAK11ZOew7hDnRKcvXxelLFKvqaTzYsIs-lbGU9gklhwbW96zurtQ_LQ9r4&_nc_ht=scontent.fros2-2.fna&oh=00_AT95r6a_TOuB-LXGSzoubZNKOqVZLZHv1PKm5PApzcthGw&oe=61D76091" width="200" height="400" />
<img src="https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/270337528_10209803550881381_7609065281288933050_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=730e14&_nc_ohc=819qkEUSdrsAX87qf2w&_nc_ht=scontent.fros2-2.fna&oh=00_AT9IyeND0AYN7FGOqLSPp66ClfbK3EojWOj6j0TuvnLxwg&oe=61D6ACA5" data-canonical-src="https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/270337528_10209803550881381_7609065281288933050_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=730e14&_nc_ohc=819qkEUSdrsAX87qf2w&_nc_ht=scontent.fros2-2.fna&oh=00_AT9IyeND0AYN7FGOqLSPp66ClfbK3EojWOj6j0TuvnLxwg&oe=61D6ACA5" width="200" height="400" />
<img src="https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/270182571_10209803551761403_6215383156601789411_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=730e14&_nc_ohc=jlLTz9EpRSkAX-3Al3_&_nc_ht=scontent.fros2-2.fna&oh=00_AT_nhK-4ibSBxB00MWr-eG1-HLxC3AO7TlEWcVvSJ0X1AA&oe=61D712C5" data-canonical-src="https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/270182571_10209803551761403_6215383156601789411_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=730e14&_nc_ohc=jlLTz9EpRSkAX-3Al3_&_nc_ht=scontent.fros2-2.fna&oh=00_AT_nhK-4ibSBxB00MWr-eG1-HLxC3AO7TlEWcVvSJ0X1AA&oe=61D712C5" width="200" height="400" />
</p>

![PowerMeterIMG7]()


> Electrónica

Mediante un circuito conectado sobre las térmicas de entrada de la casa, un NodeMCU es encargado de guardar valores y subirlos a una base de datos en Firebase. Este es conectado en el cableado 220V tanto para alimentarse a sí mismo como para sensar. 

La imagen muestra un NodeMCU junto a potenciómetros para poder forzar variaciones bruscas de corriente y diferentes cantidades subidas a firebase.

![PowerMeterIMG1](https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/268420367_10209803313755453_215219928523005467_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=730e14&_nc_ohc=FO_1kuF6dPAAX_6MWR_&_nc_ht=scontent.fros2-2.fna&oh=00_AT8RhLbehXeBhFp6ySOkJ6OA_D3Ib9xzsUacVtueTG6EvA&oe=61D6291D)
