# OGC #

## WMS ##

开放地理空间联盟 (OGC) 的 Web 地图服务 (WMS) 规范是一种在 web 上提供和使用动态地图时需遵守的国际规范。如果要在不同的平台和客户端之间以一种开放并经认可的方式提供 Web 地图，则 WMS 服务非常有用。任何原生支持 WMS 规范的客户端均可查看和使用您的服务。到目前为止，已发布了四个版本的 WMS 规范。这些版本是 v1.0.0、v1.1.0、v1.1.1 和 v1.3.0（最新版本）。

Web 地图服务（WMS）能够根据用户的请求返回相应的地图（包括PNG，GIF，JPEG等栅格形式或者是SVG和WEB CGM等矢量形式）。客户端应用程序通过向服务的 URL 附加参数来使用 WMS 服务。

规范中定义的WMS支持的操作包括:
- 请求服务的元数据(GetCapbilities) 
- 请求地图图像(GetMap) 
- 请求关于地图要素的信息 (GetFeatureInfo) 
- 请求用户自定义样式 (GetStyles) 
- 请求图例符号 (GetLegendGraphic)

由各种不同GIS Server发布的WMS服务无需支持所有操作，但如果作为基本 WMS，则必须至少支持 GetCapabilities 和 GetMap 操作。

WMS GetCapabilities实例
http://sampleserver1.arcgisonline.com/ArcGIS/services/Specialty/ESRI_StatesCitiesRivers_USA/MapServer/WMSServer?service=WMS&request=GetCapabilities&version=1.3.0

GetMap实例
http://sampleserver1.arcgisonline.com/ArcGIS/services/Specialty/ESRI_StatesCitiesRivers_USA/MapServer/WMSServer?VERSION=1.3.0&REQUEST=GetMap&CRS=CRS:84&BBOX=-178.217598,18.924782,-66.969271,71.406235&WIDTH=765&HEIGHT=360&LAYERS=0,1&STYLES=,&EXCEPTIONS=application/vnd.ogc.se_xml&FORMAT=image/png&BGCOLOR=0xFFFFFF&TRANSPARENT=TRUE