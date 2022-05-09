
## PowerMeter

En Argentina las facturas de consumo eléctrico son bimestrales, por lo cual uno no sabe cuánto es el consumo que lleva aproximado hasta que lee su factura. En verano esta situación hace que exista incertidumbre, ya que al utilizar aires acondicionados o electrodomésticos para enfriar suelen consumir en grandes cantidades. 

PowerMeter está compuesto por dos partes, electrónica y app. 

> App 

Para la construcción de la app utilice Android Studio como IDE, junto a Firebase como database, mediante consultas se generaban las estadísticas dentro de la app.

La busqueda de cada seccion de la app fue sectorizar la informacion obtenida. Tension y corriente actual, potencia consumida en graficas temporales y costo al dia actual.

> Capturas de la app

<p float="left">
    <img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270218536_10209803551601399_6434419400141604651_n.jpg?_nc_cat=101&ccb=1-6&_nc_sid=730e14&_nc_ohc=XuayylPsTLgAX_MWnch&tn=QSDM3Ops55fQHkQT&_nc_ht=scontent.fros2-1.fna&oh=00_AT9hZJbB7AW35DOxLJyiuZD390tkwZG7opkHHzppPfU3MA&oe=627D47AD" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270218536_10209803551601399_6434419400141604651_n.jpg?_nc_cat=101&ccb=1-6&_nc_sid=730e14&_nc_ohc=XuayylPsTLgAX_MWnch&tn=QSDM3Ops55fQHkQT&_nc_ht=scontent.fros2-1.fna&oh=00_AT9hZJbB7AW35DOxLJyiuZD390tkwZG7opkHHzppPfU3MA&oe=627D47AD" width="200" height="400" />
  
  <img src="https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/270277274_10209803551161388_5546425450129861146_n.jpg?_nc_cat=110&ccb=1-6&_nc_sid=730e14&_nc_ohc=CLti7y9KE8sAX_KR9mP&_nc_oc=AQkOxiAP3wVsROAh4-feSWfU75goElk1mjh3p0WbQQb237yhCE3BtOJxy4QnODkHoJM&_nc_ht=scontent.fros2-2.fna&oh=00_AT_K5_v6iOVDz_CYPSiAwUmm3TXW0drdEefCyvi5HZf_2w&oe=627D7D91" data-canonical-src="https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/270277274_10209803551161388_5546425450129861146_n.jpg?_nc_cat=110&ccb=1-6&_nc_sid=730e14&_nc_ohc=CLti7y9KE8sAX_KR9mP&_nc_oc=AQkOxiAP3wVsROAh4-feSWfU75goElk1mjh3p0WbQQb237yhCE3BtOJxy4QnODkHoJM&_nc_ht=scontent.fros2-2.fna&oh=00_AT_K5_v6iOVDz_CYPSiAwUmm3TXW0drdEefCyvi5HZf_2w&oe=627D7D91" width="200" height="400" />
  
  <img src="https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/270337528_10209803550881381_7609065281288933050_n.jpg?_nc_cat=105&ccb=1-6&_nc_sid=730e14&_nc_ohc=aA2bBoHyx9MAX9JCWk0&_nc_ht=scontent.fros2-2.fna&oh=00_AT_PCyfLQ0LtH6KF5HxFw2AYnlVVAmnK5umhKQmemBW3Ig&oe=627EC3E5" data-canonical-src="https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/270337528_10209803550881381_7609065281288933050_n.jpg?_nc_cat=105&ccb=1-6&_nc_sid=730e14&_nc_ohc=aA2bBoHyx9MAX9JCWk0&_nc_ht=scontent.fros2-2.fna&oh=00_AT_PCyfLQ0LtH6KF5HxFw2AYnlVVAmnK5umhKQmemBW3Ig&oe=627EC3E5" width="200" height="400" />

  <img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/269600828_10209803550841380_1296861305794778704_n.jpg?_nc_cat=108&ccb=1-6&_nc_sid=730e14&_nc_ohc=UBIFrzWxUg8AX_n9yLA&tn=QSDM3Ops55fQHkQT&_nc_ht=scontent.fros2-1.fna&oh=00_AT9Tud05xq4JqVhfa26qs_v-pTvL-_rHoyB5jmpmZdgXKQ&oe=627E2413" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/269600828_10209803550841380_1296861305794778704_n.jpg?_nc_cat=108&ccb=1-6&_nc_sid=730e14&_nc_ohc=UBIFrzWxUg8AX_n9yLA&tn=QSDM3Ops55fQHkQT&_nc_ht=scontent.fros2-1.fna&oh=00_AT9Tud05xq4JqVhfa26qs_v-pTvL-_rHoyB5jmpmZdgXKQ&oe=627E2413" width="200" height="400" />

  <img src="https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/270182571_10209803551761403_6215383156601789411_n.jpg?_nc_cat=110&ccb=1-6&_nc_sid=730e14&_nc_ohc=rPoJ83loSdgAX_Uil2w&_nc_ht=scontent.fros2-2.fna&oh=00_AT_vzjU-OOcnhQCazorMUGEqn0ju6-feEiCoZ-xjznj5-A&oe=627D2FC5" data-canonical-src="https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/270182571_10209803551761403_6215383156601789411_n.jpg?_nc_cat=110&ccb=1-6&_nc_sid=730e14&_nc_ohc=rPoJ83loSdgAX_Uil2w&_nc_ht=scontent.fros2-2.fna&oh=00_AT_vzjU-OOcnhQCazorMUGEqn0ju6-feEiCoZ-xjznj5-A&oe=627D2FC5" width="200" height="400" />
</p>

![PowerMeterIMG7](https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Video%202022-01-02%20at%2019.53.gif)


> Electrónica

Mediante un circuito conectado sobre las térmicas de entrada de la casa, un NodeMCU es encargado de guardar valores y subirlos a una base de datos en Firebase. Este es conectado en el cableado 220V tanto para alimentarse a sí mismo como para sensar. 

La imagen muestra un NodeMCU junto a potenciómetros para poder forzar variaciones bruscas de corriente y diferentes cantidades subidas a firebase.

![PowerMeterIMG1](https://scontent.fros2-2.fna.fbcdn.net/v/t39.30808-6/268420367_10209803313755453_215219928523005467_n.jpg?stp=dst-jpg_s960x960&_nc_cat=110&ccb=1-6&_nc_sid=730e14&_nc_ohc=6Nrbwsd5P6kAX-ShDk8&_nc_ht=scontent.fros2-2.fna&oh=00_AT8sBV5XJZrryojLxUYYkheDX420uclCEuGpDgWhA_loxA&oe=627E405D)
