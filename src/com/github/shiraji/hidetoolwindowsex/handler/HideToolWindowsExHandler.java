package com.github.shiraji.hidetoolwindowsex.handler;

import com.github.shiraji.hidetoolwindowsex.util.HideToolWindowsExUtils;
import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;

public class HideToolWindowsExHandler extends TypedHandlerDelegate {
    @Override
    public Result charTyped(char c, Project project, Editor editor, PsiFile file) {
        HideToolWindowsExUtils.hide(project);
        return Result.CONTINUE;
    }
}
