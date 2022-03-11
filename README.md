
## PowerMeter

En Argentina las facturas de consumo eléctrico son bimestrales, por lo cual uno no sabe cuánto es el consumo que lleva aproximado hasta que lee su factura. En verano esta situación hace que exista incertidumbre, ya que al utilizar aires acondicionados o electrodomésticos para enfriar suelen consumir en grandes cantidades. 

PowerMeter está compuesto por dos partes, electrónica y app. 

> App 

Para la construcción de la app utilice Android Studio como IDE, junto a Firebase como database, mediante consultas se generaban las estadísticas dentro de la app.

La busqueda de cada seccion de la app fue sectorizar la informacion obtenida. Tension y corriente actual, potencia consumida en graficas temporales y costo al dia actual.

> Capturas de la app

<p float="left">
    <img src="https://scontent.fros9-2.fna.fbcdn.net/v/t39.30808-6/270218536_10209803551601399_6434419400141604651_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=730e14&_nc_ohc=iycxk9R8LasAX9dx5ig&_nc_ht=scontent.fros9-2.fna&oh=00_AT-W6Gu7kEbDb_52-CYEEM7mjr2DdV2PqDtxY0F8g00ktw&oe=623027ED" data-canonical-src="https://scontent.fros9-2.fna.fbcdn.net/v/t39.30808-6/270218536_10209803551601399_6434419400141604651_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=730e14&_nc_ohc=iycxk9R8LasAX9dx5ig&_nc_ht=scontent.fros9-2.fna&oh=00_AT-W6Gu7kEbDb_52-CYEEM7mjr2DdV2PqDtxY0F8g00ktw&oe=623027ED" width="200" height="400" />
  
    <img src="https://scontent.fros9-1.fna.fbcdn.net/v/t39.30808-6/269600828_10209803550841380_1296861305794778704_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=Hfg8bgnqBdQAX8N-ToJ&tn=h69wmpM9SRohpJgs&_nc_ht=scontent.fros9-1.fna&oh=00_AT8jaxNTZWbYGHj-kZ7CDIgCNcAiQTvKh0SZ7q9RuKGU8w&oe=62310453" data-canonical-src="https://scontent.fros9-1.fna.fbcdn.net/v/t39.30808-6/269600828_10209803550841380_1296861305794778704_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=Hfg8bgnqBdQAX8N-ToJ&tn=h69wmpM9SRohpJgs&_nc_ht=scontent.fros9-1.fna&oh=00_AT8jaxNTZWbYGHj-kZ7CDIgCNcAiQTvKh0SZ7q9RuKGU8w&oe=62310453" width="200" height="400" />
  
    <img src="https://scontent.fros9-1.fna.fbcdn.net/v/t39.30808-6/270277274_10209803551161388_5546425450129861146_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=730e14&_nc_ohc=cGb5x2ErzFoAX-MKt2j&_nc_oc=AQmSnCGq-wfR-SE9ephWjoV4lCWYKmviAigRXKE3tGkwuKg-c6PZB0WR01QvsSHqJ04&_nc_ht=scontent.fros9-1.fna&oh=00_AT-7a23mS2aIKlmxQDct1TKigmI3I7vT-WbHEpNY56IszA&oe=62305DD1" data-canonical-src="https://scontent.fros9-1.fna.fbcdn.net/v/t39.30808-6/270277274_10209803551161388_5546425450129861146_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=730e14&_nc_ohc=cGb5x2ErzFoAX-MKt2j&_nc_oc=AQmSnCGq-wfR-SE9ephWjoV4lCWYKmviAigRXKE3tGkwuKg-c6PZB0WR01QvsSHqJ04&_nc_ht=scontent.fros9-1.fna&oh=00_AT-7a23mS2aIKlmxQDct1TKigmI3I7vT-WbHEpNY56IszA&oe=62305DD1" width="200" height="400" />

  <img src="https://scontent.fros9-2.fna.fbcdn.net/v/t39.30808-6/270337528_10209803550881381_7609065281288933050_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=730e14&_nc_ohc=tnRnzsRwhYYAX9ZCCr0&tn=h69wmpM9SRohpJgs&_nc_ht=scontent.fros9-2.fna&oh=00_AT_v9FGMEMCqOjYtUpV0r_9GHbJx282u5UBvXDZmSJpueA&oe=622FA9E5" data-canonical-src="https://scontent.fros9-2.fna.fbcdn.net/v/t39.30808-6/270337528_10209803550881381_7609065281288933050_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=730e14&_nc_ohc=tnRnzsRwhYYAX9ZCCr0&tn=h69wmpM9SRohpJgs&_nc_ht=scontent.fros9-2.fna&oh=00_AT_v9FGMEMCqOjYtUpV0r_9GHbJx282u5UBvXDZmSJpueA&oe=622FA9E5" width="200" height="400" />

  <img src="https://scontent.fros9-1.fna.fbcdn.net/v/t39.30808-6/270182571_10209803551761403_6215383156601789411_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=730e14&_nc_ohc=ZIsi_gyaLsAAX9KV7yb&_nc_ht=scontent.fros9-1.fna&oh=00_AT_W1Y2YBUwiSb1f6ookfr9SXhOn4PgGBmdoURnoLZsXKA&oe=62301005" data-canonical-src="https://scontent.fros9-1.fna.fbcdn.net/v/t39.30808-6/270182571_10209803551761403_6215383156601789411_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=730e14&_nc_ohc=ZIsi_gyaLsAAX9KV7yb&_nc_ht=scontent.fros9-1.fna&oh=00_AT_W1Y2YBUwiSb1f6ookfr9SXhOn4PgGBmdoURnoLZsXKA&oe=62301005" width="200" height="400" />
</p>

![PowerMeterIMG7](https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Video%202022-01-02%20at%2019.53.gif)


> Electrónica

Mediante un circuito conectado sobre las térmicas de entrada de la casa, un NodeMCU es encargado de guardar valores y subirlos a una base de datos en Firebase. Este es conectado en el cableado 220V tanto para alimentarse a sí mismo como para sensar. 

La imagen muestra un NodeMCU junto a potenciómetros para poder forzar variaciones bruscas de corriente y diferentes cantidades subidas a firebase.

![PowerMeterIMG1](https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/268420367_10209803313755453_215219928523005467_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=730e14&_nc_ohc=FO_1kuF6dPAAX_6MWR_&_nc_ht=scontent.fros2-2.fna&oh=00_AT8RhLbehXeBhFp6ySOkJ6OA_D3Ib9xzsUacVtueTG6EvA&oe=61D6291D)
