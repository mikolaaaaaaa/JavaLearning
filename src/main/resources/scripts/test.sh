#!/bin/bash
echo "Calling Open AI..."
MY_OPENAI_KEY="sk-proj-UJUe32fWhIsqBcKEwb2JT3BlbkFJOMJqAfBbhEU0Y0rQlVeV"
PROMPT="When was the first version of Java released?"

curl https://api.openai.com/v1/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $MY_OPENAI_KEY" \
  -d '{"model": "gpt-3.5-turbo", "messages": [{"role":"user", "content": "'"${PROMPT}"'"}] }'