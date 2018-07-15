$(document).ready(function () {

    randomRecipe();

    function randomRecipe(){
        $.ajax({
            url : 'http://localhost:8080/randomRecipe/',
            type : 'POST',
            dataType : 'JSON',
            success : function (data) {
                var header = data.name;
                var image = data.image;
                var ingredients = data.ingredients;
                var preparation = data.preparation;
                

                var dataToDisplay = "<div class='receta col-sm-12 col-md-8 col-lg-8 col-xl-8'>"+
                                        "<section>"+
                                            "<header class='header'><p>"+header+"</p></header>"+
                                            "<img src='/img/imagedb/"+image+"' alt='imagen'>"+
                                            "<main>"+ingredients+"<br/>"+preparation+"</main>"+
                                            "<footer></footer>"+
                                        "</section>"+
                                    "</div>";
                    

               $('#displayDataDiv').html(dataToDisplay);
          }
        })
    }



    $('.nav-link').click(function(){
        var category = $(this).attr('id');
        categorySelected(category);
    });

    function categorySelected(category){
      $.ajax({
        url : 'http://localhost:8080/categories/'+category+'/',
        type : 'POST',
        dataType : 'JSON',
        success : function (data) {
            var dataToDisplay= "<div class='receta col-sm-12 col-md-8 col-lg-8 col-xl-8 pb-5'>"+
                                "<div class='categoryTitle pt-4 pb-4'>"+category+"</div>";

            if(data!=null){
                for(var i=0;i<data.length;i++){
                    dataToDisplay += '<img src="/img/imagedb/'+data[i].image+'" class="recipeList img-thumbnail img-fluid rounded float-left d-block" alt="Responsive image" id='+data[i].id+'>';
                }
            }
            dataToDisplay +="</div>";

           $('#displayDataDiv').html(dataToDisplay);
      }
      })
    }


    $('body').on('click','.recipeList', function(){
        var id = $(this).attr('id');;
        getRecipe(id);
    });

    function getRecipe(id) {
        $.ajax({
            url : 'http://localhost:8080/recipe/'+id+'/',
            type : 'POST',
            dataType : 'JSON',
            success : function (data) {
                var header = data.name;
                var image = data.image;
                var ingredients = data.ingredients;
                var preparation = data.preparation;


                var dataToDisplay = "<div class='receta col-sm-12 col-md-8 col-lg-8 col-xl-8'>"+
                    "<section>"+
                    "<header class='header'><p>"+header+"</p></header>"+
                    "<img src='/img/imagedb/"+image+"' alt='imagen'>"+
                    "<main>"+ingredients+"<br/>"+preparation+"</main>"+
                    "<footer></footer>"+
                    "</section>"+
                    "</div>";


                $('#displayDataDiv').html(dataToDisplay);
            }
        })
    }



});