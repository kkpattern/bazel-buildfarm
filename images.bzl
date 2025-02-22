"""
buildfarm images that can be imported into other WORKSPACE files
"""

load("@io_bazel_rules_docker//repositories:deps.bzl", container_deps = "deps")
load("@io_bazel_rules_docker//container:container.bzl", "container_pull")

def buildfarm_images():
    """
    Pull the necessary base containers to be used for image definitions.
    """

    container_deps()

    container_pull(
        name = "java_image_base",
        digest = "sha256:8c1769cb253bdecc257470f7fba05446a55b70805fa686f227a11655a90dfe9e",
        registry = "gcr.io",
        repository = "distroless/java",
    )

    container_pull(
        name = "java_debug_image_base",
        digest = "sha256:57c99181c9dea202a185970678f723496861b4ce3c534f35f29fe58964eb720c",
        registry = "gcr.io",
        repository = "distroless/java",
    )

    container_pull(
        name = "ubuntu-bionic",
        registry = "index.docker.io",
        repository = "bazelbuild/buildfarm-worker-base",
        tag = "bionic-java11-gcc",
    )

    container_pull(
        name = "amazon_corretto_java_image_base",
        registry = "index.docker.io",
        repository = "amazoncorretto",
        tag = "18",
    )
