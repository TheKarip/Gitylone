package org.example.common.controller;

import org.example.common.ApiClient;
import org.example.common.pojo.Repository;

import static io.restassured.http.Method.DELETE;
import static io.restassured.http.Method.POST;

public class ReposController {

    private final static String CREATE_REPO = "/user/repos";
    private final static String DELETE_REPO = "/repos/{owner}/{repo}";

    public void createPublicRepository(Repository repository) {
        new ApiClient().setBody(repository).build().
                sendRequest(POST, 201, CREATE_REPO);
    }

    public void deleteRepositoryHasName(String owner, String repoName) {
        new ApiClient().build().sendRequest(DELETE, 204,
                DELETE_REPO, owner, repoName);
    }

}