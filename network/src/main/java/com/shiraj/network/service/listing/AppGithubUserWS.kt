package com.shiraj.network.service.listing

import com.shiraj.core.model.GithubUserModel
import com.shiraj.core.webservice.GithubUserWS
import com.shiraj.network.response.toItemList
import com.shiraj.network.service.networkCall
import javax.inject.Inject

internal class AppGithubUserWS @Inject constructor(
    private val githubUserWebService: RetrofitGithubUserWebService
) : GithubUserWS {

    override suspend fun getGithubUserWS(): List<GithubUserModel.Item> = networkCall(
        { githubUserWebService.getGithubUsers("Shiraj") },
        { response -> response.items.map { it.toItemList() } }
    )
}