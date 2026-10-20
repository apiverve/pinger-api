from setuptools import setup, find_packages

setup(
    name='apiverve_domainandippinger',
    version='1.2.1',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Domain and IP Pinger checks whether any domain name or public IP address is reachable and responding in real time. It returns an alive status and successful round trips, while paid plans add packet loss percentages and latency metrics.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/pinger?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
