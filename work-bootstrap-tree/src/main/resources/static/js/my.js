$(function () {

    function getTreeData() {
        var defaultData = [
            {
                "id": 0,
                "icon": "talent-icon-folder",
                "text": "计算机科学",
                "nodes": [
                    {
                        "id": 1,
                        "icon": "talent-icon-folder",
                        "text": "软件工程",
                        "nodes": [
                            {
                                "id": 2,
                                "icon": "talent-icon-file",
                                "text": "图形学"
                            },
                            {
                                "id": 3,
                                "icon": "talent-icon-file",
                                "text": "大数据运算"
                            }
                        ]
                    },
                    {
                        "id": 4,
                        "icon": "talent-icon-file",
                        "text": "微机原理"
                    }
                ]
            },
            {
                "id": 5,
                "icon": "talent-icon-folder",
                "text": "土木工程",
                "state": {
                    "checked": true
                }
            },
            {
                "id": 6,
                "icon": "talent-icon-folder",
                "text": "市场营销"
            }
        ];
        return defaultData;
    }


    var $checkableTree = $('#tree').treeview({
        data: getTreeData(),
        levels: 3,
        showIcon: true,
        showCheckbox: true,
        showBorder: false,
        /*multiSelect: true,*/
        selectedColor: 'back',
        selectedBackColor: 'white',
        expandIcon: 'talent-icon-towards-the-right',
        collapseIcon: 'talent-icon-down',
        checkedIcon: 'talent-icon-check',
        uncheckedIcon: 'talent-icon-checkbox',
        onNodeChecked: function (event, node) {
            console.log(node.id);
            $('#output').prepend('<p>' + node.text + ' was checked</p>');

            // parent-有子必有父
            function doCheckedNode(node) {
                // 初始化
                var thisDiv = $('#tree');
                var parentNode = thisDiv.treeview('getParent', node);
                if (parentNode && 0 <= parentNode.nodeId) {
                    console.log(parentNode);
                    // 选中
                    thisDiv.treeview('checkNode', [parentNode, {silent: true}]);
                    // 递归
                    doCheckedNode(parentNode);
                }
            }

            doCheckedNode(node);
        },
        onNodeUnchecked: function (event, node) {
            $('#output').prepend('<p>' + node.text + ' was unchecked</p>');

            // child-无父无子
            function doUnCheckedNode(node) {
                // 初始化
                var thisDiv = $('#tree');
                if (node && node.nodes && 0 < node.nodes.length) {
                    var childNodes = node.nodes;
                    for (var i = 0, len = childNodes.length; i < len; i++) {
                        // 取消选中
                        thisDiv.treeview('uncheckNode', [childNodes[i].nodeId, {silent: true}]);
                        // 递归
                        doUnCheckedNode(childNodes[i]);
                    }
                }
            }

            doUnCheckedNode(node);
        }
    });
    $('#btn-check-all').on('click', function (e) {
        $checkableTree.treeview('checkAll', {silent: $('#chk-check-silent').is(':checked')});
    });
    $('#btn-uncheck-all').on('click', function (e) {
        $checkableTree.treeview('uncheckAll', {silent: $('#chk-check-silent').is(':checked')});
    });




});