<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AI Time Sieres Prediction</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Logo_del_Ministerio_de_Educaci%C3%B3n_del_Per%C3%BA_-_MINEDU.png/1600px-Logo_del_Ministerio_de_Educaci%C3%B3n_del_Per%C3%BA_-_MINEDU.png" alt="" height="60px">
<h4>Predicciones</h4>

<hr>
<select class="form-select" aria-label="Default select example" id="dpto">
  <option selected>Seleccione departamento</option>
  <option value="1">Lima</option>
  <option value="2">Ica</option>
</select>
<div id="result">
<div id="res1" style="display: none">
    <p>PBI Nacional</p>
    <img src="<%/templates/assets/lima-prediction-pbi-1.png%>" height="446" width="1311"/>
    <p>Denuncias de agresión física y psicológica</p>
    <img src="~/templates/assets/lima-prediction-denuncias-agresion-fisica-psico-1.png" height="446"
                                                                                             width="1311"/>
    <p>Matriculados en gestión pública y privada</p>

    <img src="~/templates/assets/lima-prediction-matriculados-pub-priv-1.png" height="446" width="1311"/>
</div>
<div id="res2" style="display: none"> No hay resultados</div>
</div>
<script>
  var dpto = document.getElementById('dpto');
  dpto.addEventListener('change', function (){
var res1 = document.getElementById('res1');
var res2 = document.getElementById('res2');
if (dpto.value == 1) {
    //alert(this.value);
    res1.style.display= 'block';
    res2.style.display= 'none';
}else {
    res1.style.display= 'none';
    res2.style.display= 'block';
}
  })
</script>
</body>
</html>