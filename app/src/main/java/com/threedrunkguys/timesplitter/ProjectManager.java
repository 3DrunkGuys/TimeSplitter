package com.threedrunkguys.timesplitter;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 8/7/2015.
 *
 * Manages all interactions with Project objects.
 * Creation, deletion, etc.
 */
public class ProjectManager {
    private static ProjectManager projectManager;
    private List<Project> projects;
    private DBHandler dbHandler;

    private ProjectManager(Context context){
        projects = new ArrayList<Project>();

        dbHandler = DBHandler.getDbHandler(context);
    }

    // Singleton
    public static ProjectManager getProjectManager(Context context){
        if(projectManager == null)
            projectManager = new ProjectManager(context);

        return projectManager;
    }

    public Project createProject(String projectName){
        return createProjectHelper(projectName, "");
    }

    public Project createProject(String projectName, String projectNote){
        return createProjectHelper(projectName, projectNote);
    }

    private Project createProjectHelper(String projectName, String projectNote){
        long projectID = dbHandler.createProject(projectName, projectNote);

        Project newProject = new Project(projectID, projectName, projectNote);

        projects.add(newProject);

        return newProject;
    }

    public void deleteProject(Project project){
        dbHandler.deleteProject(project.getID());

        projects.remove(project);

        project = null;
    }

    public List<Project> getAllProjects(){
        return projects;
    }
}
