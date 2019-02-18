package org.devil.demo.zookeeper;

import org.apache.log4j.Logger;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

public class ZookeeperTemplate {

    public Logger logger = Logger.getLogger(ZookeeperTemplate.class);
    public static final String CONNECTSTRING = "192.168.182.128:2181";
    public static final String PATH = "/test";
    public static final int SEESIONTIMEOUT = 20 * 1000;

    private ZooKeeper zookeeper;

    public ZooKeeper start()  {
        try {
            zookeeper = new ZooKeeper(CONNECTSTRING, SEESIONTIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zookeeper;
    }

    public void create(ZooKeeper zk, String path, String data) throws KeeperException, InterruptedException {
        zookeeper.create(path,data.getBytes(), OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public String get(ZooKeeper zk, String path) throws KeeperException, InterruptedException {
        return new String(zookeeper.getData(path, false, new Stat()));
    }

    public void stop(ZooKeeper zk){
        try {
            zookeeper.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZookeeperTemplate template = new ZookeeperTemplate();
        ZooKeeper zk = template.start();
        template.create(zk,PATH,"aaa");
        String data = template.get(zk,PATH);
        System.out.println(data);
        template.stop(zk);
    }

    public ZooKeeper getZookeeper() {
        return zookeeper;
    }

    public void setZookeeper(ZooKeeper zookeeper) {
        this.zookeeper = zookeeper;
    }
}
