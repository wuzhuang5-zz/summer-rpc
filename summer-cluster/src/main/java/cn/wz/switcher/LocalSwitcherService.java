package cn.wz.switcher;

import java.util.List;

public class LocalSwitcherService implements SwitcherService{
    @Override
    public Switcher getSwitcher(String name) {
        return null;
    }

    @Override
    public List<Switcher> getSwitchers() {
        return null;
    }

    @Override
    public void initSwitcher(String switcherName, boolean initialValue) {

    }

    @Override
    public boolean isOpen(String switcherName) {
        return false;
    }

    @Override
    public void setValue(String switcherName, boolean value) {

    }
}
