$(document).ready(function () {

    createSelect();

    function createSelect() {
        $.ajax({
            url : 'http://localhost:8080/crud/recipes/',
            type : 'GET',
            dataType : 'JSON',
            success : function (data) {
                 var info='<option value="default" selected="true">- SELECCIONA UNA RECETA O CREA UNA NUEVA -</option>';

                for(var i=0;i<data.length;i++){
                         info += '<option value='+data[i].name+' id='+data[i].id+'>'+data[i].name + '</option>';
                    }
                $('#recipeSelect').html(info);
           }
        })
    }

    $("#recipeSelect").change(function() {
        $('#recipedataform').css('display', 'block');
        var defaultOption = $("#recipeSelect option[value='default']");
        if (defaultOption) defaultOption.remove();
        var id = $(this).children(":selected").attr("id");
        //get the url for the ajax call
        var url = "/crud/recipes/" + id;
        //do the ajax call
        recipeDomReset();
        $.ajax({
            url : url,
            type : 'GET',
            dataType : 'JSON',
            success : function (data) {
                var id = data.id;
                var recipe_name = data.name;
                var ingredient = data.ingredients;
                var categories = data.categories;
                var preparation = data.preparation;
                var image = data.image;
                oneMoreIngredient(getArrayIngredients(ingredient).length);
                ingredientDataToDom(getArrayIngredients(ingredient));
                categoriesDataToDom(getArrayCategories(categories));
                $('#id').prop('value', id);
                $('#recipe_name').prop('value',recipe_name);
                $('#preparation').prop('value',preparation);
                $('#image').attr('src','img/imgdb/'+image);
                $("#recipedataform :input").prop("disabled", true);
            }
        })
    });

    function getArrayIngredients(stringToArray){
        return stringToArray.split(',');
    }

    function ingredientDataToDom(arrayOfIngredients){

        for (var i = 0; i<=arrayOfIngredients.length; i++){
            $('#ingredient_'+(i+1)).val(arrayOfIngredients[i]);

        }
    }

    function getArrayCategories(stringToArray){
        return stringToArray.split(',');
    }

    function categoriesDataToDom(arrayOfCategories) {

        for (var i = 0; i<=arrayOfCategories.length; i++) {

            $('#categoriesCheck input').each(function () {
                if (JSON.stringify(this.id) == JSON.stringify(arrayOfCategories[i])) {
                    $('#' + arrayOfCategories[i]).prop('checked', true);
                }
            })
        }

    }





    $('#newRecipe').click(function () {
        $('#recipedataform').css('display', 'block');
        recipeDomReset();
        $("#recipedataform :input").prop("disabled", false);

    })

    $('#editRecipe').click(function () {
        $("#recipedataform :input").prop("disabled", false);
    })

    function recipeDomReset(){
        $('#id').prop('value',"");
        $('#recipe_name').val("");
        $('#ingredientes input').remove();
        $('#preparation').val("");
        $('#categoriesCheck input').prop('checked', false);
    }


    function oneMore(){
        var count=0;
        var lastChild = $('#ingredientes input').last().attr('id');

        if (lastChild!=null){
            count= parseInt(lastChild.substring(lastChild.indexOf('_')+1));
        }
        count = parseInt(count)+1;
        var onemore= '<input type="text" class="form-control mt-1" name="ingredient_'+count+'" id="ingredient_'+count+'">';

        $('#ingredientes').append(onemore);

    }



    function oneMoreIngredient(number){
        for (var i = 0; i<=number-1;i++){
            oneMore();
        }

    }

    $('#onemore').click(function () {
        oneMore();
    })

    $("#submit").click(function(event) {

        var ingredients="";
        $('#ingredientes input').each(function () {
            ingredients+=$( this ).prop('value')+',';
        })

        var categories="";
        $('#categoriesCheck input').each(function () {
            if(this.checked){
                categories+=$( this ).prop('value')+',';
            }

        })

        var data = {}
        data["id"]=$('#id').prop('value');
        data["name"] = $("#recipe_name").prop('value');
        data["ingredients"] = ingredients;
        data["preparation"] = $("#preparation").prop('value');
        data["categories"] = categories;

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/crud/addRecipe",
            data: JSON.stringify(data),
            dataType: 'json',
            timeout: 600000,
            success: function (data) {

            },
            error: function (e) {

            }
        });

    });


    $('#delete').click(function () {

        var id =  $('#recipeSelect').children(":selected").prop("id");
        $.ajax({
            type : "POST",
            url : "/crud/deleteRecipe/"+id,
            contentType: "application/json",
            dataType : 'json',
            success: function (result) {
                console.log(result);

            },
            error: function (e) {
                console.log(e);
            }
        })

    })

});
