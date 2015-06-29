package com.github.shiraji.hidetoolwindowsex.action;

import com.github.shiraji.hidetoolwindowsex.util.HideToolWindowsExUtils;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;

public class HideRestoreToolWindowsAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Project project = anActionEvent.getProject();
        HideToolWindowsExUtils.hideOrRestore(project);
    }
}
