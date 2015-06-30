package com.github.shiraji.hidetoolwindowsex.util;

import com.github.shiraji.hidetoolwindowsex.config.HideToolWindowsExConfig;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowType;
import com.intellij.openapi.wm.ex.ToolWindowManagerEx;
import com.intellij.openapi.wm.impl.DesktopLayout;

public class HideToolWindowsExUtils {
    private static boolean sIsHideToolWindow;
    private static DesktopLayout sLayout;
    private static ToolWindowManagerEx sToolWindowManager;

    public static void hideOrRestore(Project project) {
        init(project);
        hideToolWindows();

        if (sIsHideToolWindow) {
            actionAfterHideToolWindows();
        } else {
            restoreToolWindows();
        }
    }

    public static void hide(Project project) {
        init(project);
        hideToolWindows();

        if (sIsHideToolWindow) {
            actionAfterHideToolWindows();
        }
    }

    private static void init(Project project) {
        sToolWindowManager = ToolWindowManagerEx.getInstanceEx(project);
        sLayout = new DesktopLayout();
        sLayout.copyFrom(sToolWindowManager.getLayout());
        sToolWindowManager.clearSideStack();
        sIsHideToolWindow = false;
    }

    private static void hideToolWindows() {
        HideToolWindowsExConfig config = HideToolWindowsExConfig.getInstance();
        for (String windowId : sToolWindowManager.getToolWindowIds()) {
            hideToolWindow(config, windowId);
        }
    }

    private static void hideToolWindow(HideToolWindowsExConfig config, String windowId) {
        ToolWindow toolWindow = sToolWindowManager.getToolWindow(windowId);
        ToolWindowAnchor anchor = toolWindow.getAnchor();
        if (toolWindow.isVisible() && toolWindow.getType() != ToolWindowType.FLOATING && isHideToolWindow(config, anchor)) {
            toolWindow.hide(null);
            sIsHideToolWindow = true;
        }
    }

    private static boolean isHideToolWindow(HideToolWindowsExConfig config, ToolWindowAnchor anchor) {
        return isHideBottomToolWindow(config, anchor)
                || isHideRightToolWindow(config, anchor)
                || isHideLeftToolWindow(config, anchor);
    }

    private static boolean isHideLeftToolWindow(HideToolWindowsExConfig config, ToolWindowAnchor anchor) {
        return config.isHideLeftToolWindow() && ToolWindowAnchor.LEFT == anchor;
    }

    private static boolean isHideRightToolWindow(HideToolWindowsExConfig config, ToolWindowAnchor anchor) {
        return config.isHideRightToolWindow() && ToolWindowAnchor.RIGHT == anchor;
    }

    private static boolean isHideBottomToolWindow(HideToolWindowsExConfig config, ToolWindowAnchor anchor) {
        return config.isHideBottomToolWindow() && ToolWindowAnchor.BOTTOM == anchor;
    }

    private static void actionAfterHideToolWindows() {
        sToolWindowManager.setLayoutToRestoreLater(sLayout);
        sToolWindowManager.activateEditorComponent();
    }

    private static void restoreToolWindows() {
        final DesktopLayout restoredLayout = sToolWindowManager.getLayoutToRestoreLater();
        if (restoredLayout != null) {
            sToolWindowManager.setLayoutToRestoreLater(null);
            sToolWindowManager.setLayout(restoredLayout);
        }
    }

}
