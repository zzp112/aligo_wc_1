/**
 * Created by Administrator on 2015-03-20.
 */
// gridId 表格ID ， json_url,获取String类型的json数据
function loadDataFromJson(gridId,json_url) {
    $.post(json_url,function (data) {
        var ob = eval('('+data+')');
        $('#'+gridId).datagrid({loadFilter: pagerFilter}).datagrid('loadData', ob);
    });
}

// 对数据的分页函数
function pagerFilter(data) {
    if (typeof data.length == 'number' && typeof data.splice == 'function') {	// is array
        data = {
            total: data.length, //json的总数据
            rows: data  //json数据
        }
    }
    var dg = $(this);
    var opts = dg.datagrid('options');
    var pager = dg.datagrid('getPager');
    //easyui对分页的数量和规模（一页显示的最大数据行数）做出处理
    pager.pagination({
        //pageSize: 10,//每页显示的记录条数，默认为10
        pageList: [10, 20, 30, 40, 50, 60, 70, 80],//可以设置每页记录条数的列表
        beforePageText: '第',//页数文本框前显示的汉字
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',

        //分页操作
        onSelectPage: function (pageNum, pageSize) {
            opts.pageNumber = pageNum;//表示第几页
            opts.pageSize = pageSize;//数据表格下面的dataobtions中设置的每页数据条数（pageSize）规模
            //刷新
            pager.pagination('refresh', {
                pageNumber: pageNum,
                pageSize: pageSize
            });
            //表格加载数据
            dg.datagrid('loadData', data);
        }
    });

    if (!data.originalRows) {
        data.originalRows = (data.rows);
    }
    //表示从第几条数据开始
    var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
    //表示结束的时候是第几条数据
    var end = start + parseInt(opts.pageSize);
    //引用easyui的originalRows的slice（start，end）对每页的数据进行分离
    data.rows = (data.originalRows.slice(start, end));
    return data;
}

