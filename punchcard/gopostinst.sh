#!/bin/bash

systemctl daemon-reload
systemctl start gopunchcard
systemctl enable gopunchcard
