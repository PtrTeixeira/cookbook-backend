# kotlin-dropwizard-dsl

Exists to provide some Kotlin-specific functionality
to make it a little bit easier for me to use
Dropwizard. Mostly these are just differently named
versions of the `let` function.

## Usage

The `configure` functions below are the important ones.
It really is just a wrapper over a handful of setters
on the `Bootstrap` and `Environment` objects.

Quick sample:

```kotlin
class CookbookApplication : Application<CookbookConfiguration>() {
    override fun initialize(bootstrap: Bootstrap<CookbookConfiguration>?) {
        configure(bootstrap) {
            bundles(migrationsBundle(), JdbiExceptionsBundle())

            configurationSource {
                useEnvironmentVariables()
            }

            objectMapper {
                registerKotlinModule()
            }
        }
    }

    override fun run(configuration: CookbookConfiguration, environment: Environment) {
        configure(environment) {
            oauthFilter<User> {
                setAuthenticator(authenticator)
            }


            resources(recipesResource)
        }
    }

    override fun getName(): String {
        return "cookbook"
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CookbookApplication()
                    .run(*args)
        }
    }
}
```
