pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "JetReddit"
include(":app")
include(":core:models")
include(":core:network")
include(":core:database")
include(":feature:subreddits")
include(":feature:on_boarding")
include(":feature:auth")
include(":feature:favorites")
include(":feature:profile")
include(":feature:friends")
include(":feature:user")
include(":feature:single_subreddit")
include(":res:drawables")
include(":res:strings")
