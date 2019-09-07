#!/bin/bash

systemctl daemon-reload
systemctl start punchcard
systemctl enable punchcard
