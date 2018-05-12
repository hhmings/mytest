package cn.hhm.workbootstraptree.sercice;

import cn.hhm.workbootstraptree.dao.PartJpa;
import cn.hhm.workbootstraptree.dao.UserJpa;
import cn.hhm.workbootstraptree.entity.Nodes;
import cn.hhm.workbootstraptree.entity.TPart;
import cn.hhm.workbootstraptree.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ming
 * @create 2018-04-22 15:49
 */
@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    private UserJpa userJpa;
    @Autowired
    private PartJpa partJpa;

    @Override
    public List<Nodes> getNode() {
        List<TPart> onePartList = partJpa.findTPartByParentId(0);
        List<Nodes> nodesList = new ArrayList<>();

        Nodes nodes = null;
        for (TPart part : onePartList) {
            //获取下级部门
            int pid = part.getId();
            List<Nodes> nodesList1 = getNodesList(pid);

            nodes = new Nodes(part.getPartname(), pid + "", 1, nodesList1 == null ? null : nodesList1);
            nodesList.add(nodes);
        }
        createNodeList(nodesList);

        return nodesList;
    }

    public void createNodeList(List<Nodes> nodesList) {
        for (Nodes node : nodesList) {
            if (node.getIsPart() == 1) {
                int pid = Integer.parseInt(node.getId());
                List<Nodes> userNode = getUserNode(pid);

                List<Nodes> nodes = node.getNodes();
                if (nodes != null && nodes.size() > 0) {
                    if (userNode != null) {
                        nodes.addAll(userNode);
                    }
                    createNodeList(nodes);
                } else {
                    node.setNodes(userNode);
                }
            }
        }
    }

    public List<Nodes> getNodesList(int pid) {
        List<Nodes> childNodeList = new ArrayList<>();
        List<TPart> onePartList = partJpa.findTPartByParentId(pid);
        //查部门
        if (onePartList != null && onePartList.size() > 0) {
            Nodes nodes = null;
            for (TPart part1 : onePartList) {
                int ids = part1.getId();
                List<Nodes> nodesList1 = getNodesList(ids);
                nodes = new Nodes(part1.getPartname(), part1.getId().toString(), 1, nodesList1 == null ? null : nodesList1);
                childNodeList.add(nodes);
            }
            return childNodeList;
        }
        return null;

    }

    public List<Nodes> getUserNode(int pid) {
        List<Nodes> childNodeList = null;
        List<TUser> userList = userJpa.findTUserByPid(pid);
        if (userList != null && userList.size() > 0) {
            childNodeList = new ArrayList<>();
            Nodes nodes = null;
            for (TUser user : userList) {
                nodes = new Nodes(user.getUsername(), user.getId().toString(), -1, null);
                childNodeList.add(nodes);
            }
            return childNodeList;
        }
        return null;
    }


}
