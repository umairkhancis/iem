$(document).ready(function() {
	$("#grid").jqGrid({
		url : "category/getJson",
		mtype: "get",
		datatype : "json",

		jsonReader : {
			repeatitems : false,
		},

		colNames : [ 'Category ID', 'Category Name', 'Category Desciption' ],

		colModel : [ {
			name : 'id',
			width : 150,
			editable: false,
			editoptions:{readonly:true,size:10}
		}, {
			name : 'name',
			width : 150,
			editable:true,
			editoptions:{size:10}
		}, {
			name : 'description',
			width : 150,
			editable:true,
			editoptions:{size:10}
		} ],
		rowNum : 10,
		rowList : [ 5, 10, 15 ],
		height : 230,
		pager : "#pager",
		viewrecords : true,
		sortname : 'id',
		sortorder : "desc",
		caption : "Categories",
		editurl : "category/edit"
	});
	
	$("#btnEdit").on("click", function(){
		var gr = $("#grid").jqGrid('getGridParam','selrow');
		if( gr != null ) 
			$("#grid").jqGrid('editGridRow',gr,{height:280,reloadAfterSubmit:true});
		else 
			alert("Please Select Row");
	});
	
	$("#btnAdd").on("click", function(){
			$("#grid").jqGrid('editGridRow',"new",{height:280,reloadAfterSubmit:true});
	});
	
	$("#btnDel").on("click", function(){
		var gr = jQuery("#grid").jqGrid('getGridParam','selrow');
		if( gr != null ) jQuery("#grid").jqGrid('delGridRow',gr,{reloadAfterSubmit:true});
		else alert("Please Select Row to delete!");
	});

});




function addCategoryInputRow() {
	// alert("hello");
	$("#tableRowGroup:first-child").clone().appendTo(".container");

}
