### Github API 연동입니다

+ 화면 2개를 구성하여 첫번째 화면은 사용자의 간단한 정보
+ 두번쨰 화면에는 사용자가 작성했던 글과 글의 정보들을 가져옵니다
+ REST API / JSON
+ 참고
  + [GitHub Developer](https://developer.github.com/v3/users/)
  
+ 요청
 + https://api.github.com/users/octocat
 
+ 결과
``` json
{
  "login": "octocat",
  "id": 583231,
  "node_id": "MDQ6VXNlcjU4MzIzMQ==",
  "avatar_url": "https://avatars3.githubusercontent.com/u/583231?v=4",
  "gravatar_id": "",
  "url": "https://api.github.com/users/octocat",
  "html_url": "https://github.com/octocat",
  "followers_url": "https://api.github.com/users/octocat/followers",
  "following_url": "https://api.github.com/users/octocat/following{/other_user}",
  "gists_url": "https://api.github.com/users/octocat/gists{/gist_id}",
  "starred_url": "https://api.github.com/users/octocat/starred{/owner}{/repo}",
  "subscriptions_url": "https://api.github.com/users/octocat/subscriptions",
  "organizations_url": "https://api.github.com/users/octocat/orgs",
  "repos_url": "https://api.github.com/users/octocat/repos",
  "events_url": "https://api.github.com/users/octocat/events{/privacy}",
  "received_events_url": "https://api.github.com/users/octocat/received_events",
  "type": "User",
  "site_admin": false,
  "name": "The Octocat",
  "company": "GitHub",
  "blog": "http://www.github.com/blog",
  "location": "San Francisco",
  "email": null,
  "hireable": null,
  "bio": null,
  "public_repos": 8,
  "public_gists": 8,
  "followers": 2872,
  "following": 9,
  "created_at": "2011-01-25T18:44:36Z",
  "updated_at": "2019-11-22T15:27:59Z"
}
```

***

+ 요청
  + https://api.github.com/users/octocat/repos
  
+ 결과
``` json
[
  {
    "id": 132935648,
    "node_id": "MDEwOlJlcG9zaXRvcnkxMzI5MzU2NDg=",
    "name": "boysenberry-repo-1",
    "full_name": "octocat/boysenberry-repo-1",
    "private": false,
    "owner": {
      "login": "octocat",
      "id": 583231,
      "node_id": "MDQ6VXNlcjU4MzIzMQ==",
      "avatar_url": "https://avatars3.githubusercontent.com/u/583231?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/octocat",
      "html_url": "https://github.com/octocat",
      "followers_url": "https://api.github.com/users/octocat/followers",
      "following_url": "https://api.github.com/users/octocat/following{/other_user}",
      "gists_url": "https://api.github.com/users/octocat/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/octocat/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/octocat/subscriptions",
      "organizations_url": "https://api.github.com/users/octocat/orgs",
      "repos_url": "https://api.github.com/users/octocat/repos",
      "events_url": "https://api.github.com/users/octocat/events{/privacy}",
      "received_events_url": "https://api.github.com/users/octocat/received_events",
      "type": "User",
      "site_admin": false
    },
    "html_url": "https://github.com/octocat/boysenberry-repo-1",
    "description": "Testing",
    "fork": true,
    "url": "https://api.github.com/repos/octocat/boysenberry-repo-1",
    "forks_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/forks",
    "keys_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/keys{/key_id}",
    "collaborators_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/collaborators{/collaborator}",
    "teams_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/teams",
    "hooks_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/hooks",
    "issue_events_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/issues/events{/number}",
    "events_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/events",
    "assignees_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/assignees{/user}",
    "branches_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/branches{/branch}",
    "tags_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/tags",
    "blobs_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/git/blobs{/sha}",
    "git_tags_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/git/tags{/sha}",
    "git_refs_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/git/refs{/sha}",
    "trees_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/git/trees{/sha}",
    "statuses_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/statuses/{sha}",
    "languages_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/languages",
    "stargazers_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/stargazers",
    "contributors_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/contributors",
    "subscribers_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/subscribers",
    "subscription_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/subscription",
    "commits_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/commits{/sha}",
    "git_commits_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/git/commits{/sha}",
    "comments_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/comments{/number}",
    "issue_comment_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/issues/comments{/number}",
    "contents_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/contents/{+path}",
    "compare_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/compare/{base}...{head}",
    "merges_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/merges",
    "archive_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/{archive_format}{/ref}",
    "downloads_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/downloads",
    "issues_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/issues{/number}",
    "pulls_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/pulls{/number}",
    "milestones_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/milestones{/number}",
    "notifications_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/notifications{?since,all,participating}",
    "labels_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/labels{/name}",
    "releases_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/releases{/id}",
    "deployments_url": "https://api.github.com/repos/octocat/boysenberry-repo-1/deployments",
    "created_at": "2018-05-10T17:51:29Z",
    "updated_at": "2019-11-18T14:40:09Z",
    "pushed_at": "2018-05-10T17:52:17Z",
    "git_url": "git://github.com/octocat/boysenberry-repo-1.git",
    "ssh_url": "git@github.com:octocat/boysenberry-repo-1.git",
    "clone_url": "https://github.com/octocat/boysenberry-repo-1.git",
    "svn_url": "https://github.com/octocat/boysenberry-repo-1",
    "homepage": "",
    "size": 4,
    "stargazers_count": 3,
    "watchers_count": 3,
    "language": null,
    "has_issues": false,
    "has_projects": true,
    "has_downloads": true,
    "has_wiki": true,
    "has_pages": false,
    "forks_count": 5,
    "mirror_url": null,
    "archived": false,
    "disabled": false,
    "open_issues_count": 0,
    "license": null,
    "forks": 5,
    "open_issues": 0,
    "watchers": 3,
    "default_branch": "master"
  }
]
```

+ 추가 사용 라이브러리
  + [Fresco](https://github.com/facebook/fresco)
