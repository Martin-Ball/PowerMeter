
## PowerMeter

En Argentina las facturas de consumo eléctrico son bimestrales, por lo cual uno no sabe cuánto es el consumo que lleva aproximado hasta que lee su factura. En verano esta situación hace que exista incertidumbre, ya que al utilizar aires acondicionados o electrodomésticos para enfriar suelen consumir en grandes cantidades. 

PowerMeter está compuesto por dos partes, electrónica y app. 

> App 

Para la construcción de la app utilice Android Studio como IDE, junto a Firebase como database, mediante consultas se generaban las estadísticas dentro de la app.

La busqueda de cada seccion de la app fue sectorizar la informacion obtenida. Tension y corriente actual, potencia consumida en graficas temporales y costo al dia actual.

> Capturas de la app

<p float="left">
    <img src="https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Image%202022-01-02%20at%2019.54.48%20(1).jpeg" data-canonical-src="https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Image%202022-01-02%20at%2019.54.48%20(1).jpeg" width="200" height="400" />
  
  <img src="https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Image%202022-01-02%20at%2019.54.48%20(2).jpeg" data-canonical-src="https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Image%202022-01-02%20at%2019.54.48%20(2).jpeg" width="200" height="400" />
  
  <img src="https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Image%202022-01-02%20at%2019.54.48%20(3).jpeg" data-canonical-src="https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Image%202022-01-02%20at%2019.54.48%20(3).jpeg" width="200" height="400" />

  <img src="https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Image%202022-01-02%20at%2019.54.48%20(4).jpeg" data-canonical-src="https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Image%202022-01-02%20at%2019.54.48%20(4).jpeg" width="200" height="400" />

  <img src="https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Image%202022-01-02%20at%2019.54.48.jpeg" data-canonical-src="https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Image%202022-01-02%20at%2019.54.48.jpeg" width="200" height="400" />
</p>

![PowerMeterIMG7](https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Video%202022-01-02%20at%2019.53.gif)


> Electrónica

Mediante un circuito conectado sobre las térmicas de entrada de la casa, un NodeMCU es encargado de guardar valores y subirlos a una base de datos en Firebase. Este es conectado en el cableado 220V tanto para alimentarse a sí mismo como para sensar. 

La imagen muestra un NodeMCU junto a potenciómetros para poder forzar variaciones bruscas de corriente y diferentes cantidades subidas a firebase.

![PowerMeterIMG1](https://github.com/Martin-Ball/PowerMeter/blob/main/268420367_10209803313755453_215219928523005467_n.jpg)
