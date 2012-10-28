package lab.controller;

import lab.util.UrlUtil;
import lab.viewmakers.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class PageViewer {
    private HttpServletRequest request;
    private Map<String, IViewMaker> commandMap;

    public PageViewer(HttpServletRequest request) {
        this.request = request;
        initCommands();
    }

    private void initCommands() {
        commandMap = new HashMap<String, IViewMaker>();
        commandMap.put("view.fc", new PersonViewMaker());
        commandMap.put("add.fc", new ToDbSaver());
        commandMap.put("list.fc", new PersonsListViewMaker());
    }

    public IViewMaker getCommand() {
        String commandName = UrlUtil.getCommandName(request);
        IViewMaker command = commandMap.get(commandName);
        if (command != null) {
            return command;
        }
        return new GeneralViewMaker();
    }
}
